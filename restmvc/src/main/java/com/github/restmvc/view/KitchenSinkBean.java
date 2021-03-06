package com.github.restmvc.view;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.github.restmvc.jaxrs.AbstractJaxrs;
import com.github.restmvc.jaxrs.RestmvcApplication;
import com.github.restmvc.jaxrs.ViewableTemplate;

@Path(RestmvcApplication.URI_TEMPLATE_PREFIX_VIEW
		+ KitchenSinkBean.URI_TEMPLATE)
@Named
@ManagedBean
@Stateless
public class KitchenSinkBean extends AbstractJaxrs {

	public static final String URI_TEMPLATE = "/kitchenSink";

	@GET
	public ViewableTemplate render() {
		return new ViewableTemplate(TEMPLATE_BASE_DIR + URI_TEMPLATE + ".xhtml");
	}

	public String getWelcomeUrl() {
		return getViewContextPath(null, WelcomeBean.URI_TEMPLATE);
	}
}
