package sitemap.monitor;


import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sitemap.monitor.external.SitemapNotAvailableException;
import sitemap.monitor.services.SitemapService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController implements ApplicationContextAware {
	
	private static final String SITEMAP_SERVICE = "SitemapService";
	
	private static final String ERROR_PAGE_VIEW = "error_page";
	private static final String SIMPLE_SITEMAP_VIEW = "sitemap_simple";
	private static final String HOME_PAGE_VIEW = "home";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	private ApplicationContext appContext;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return HOME_PAGE_VIEW;
	}
	
	@RequestMapping(value="/simple/{hostkey}",
					method=RequestMethod.GET)
	public String getSimpleHealthcheck(@PathVariable("hostkey") String hostkey, Model model) {
		String view;
		
		try {
			SitemapService service = getApplicationContext().getBean(SITEMAP_SERVICE, SitemapService.class);
			service.setConfigKey(hostkey);
			
			model.addAttribute("minsinceupdate", service.getMinsSinceUpdate());
			view = SIMPLE_SITEMAP_VIEW;
		} catch (SitemapNotAvailableException siteEx) {
			LOGGER.error("Error on Sitemap retrieval", siteEx);
			model.addAttribute("errormsg", siteEx.getCause().getMessage());
			view = ERROR_PAGE_VIEW;
		} catch (Exception ex) {
			LOGGER.error("Error on Sitemap retrieval", ex);
			model.addAttribute("errormsg", ex.getMessage());
			view = ERROR_PAGE_VIEW;
		}
		
		return view;
	}

	private ApplicationContext getApplicationContext() {
		return this.appContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.appContext = applicationContext;
	}
}
