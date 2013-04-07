package com.github.restmvc;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

public abstract class AbstractJaxrs {

	public static final String TEMPLATE_BASE_DIR = "/WEB-INF/view";

	@Context
	protected HttpServletRequest request;

	public void setAttribute(String name, Object value) {
		request.setAttribute(name, value);
	}

	public void removeAttribute(String name) {
		request.removeAttribute(name);
	}

	public Enumeration<String> getParameterNames() {
		return request.getParameterNames();
	}

	public String[] getParameterValues(String name) {
		return request.getParameterValues(name);
	}

	public HttpSession getSession() {
		return request.getSession();
	}

	public HttpSession getSession(boolean create) {
		return request.getSession(create);
	}

	public String getViewContextPath(String additionalUriTemplatePrefix,
			String viewUriTemplate) {
		if ((viewUriTemplate == null) || (viewUriTemplate.trim().length() == 0)) {
			return "";
		}

		StringBuilder path = new StringBuilder(request.getContextPath());
		path.append(RestmvcApplication.PATH);

		if ((additionalUriTemplatePrefix != null)
				&& (additionalUriTemplatePrefix.trim().length() > 0)
				&& !RestmvcApplication.URI_TEMPLATE_PREFIX_VIEW
						.equals(additionalUriTemplatePrefix.trim())) {
			if (!additionalUriTemplatePrefix.trim().startsWith("/")) {
				path.append("/");
			}

			path.append(additionalUriTemplatePrefix.trim());

			if (path.toString().endsWith("/")) {
				path.deleteCharAt(path.length() - 1);
			}
		}

		path.append(RestmvcApplication.URI_TEMPLATE_PREFIX_VIEW);

		if (!viewUriTemplate.trim().startsWith("/")) {
			path.append("/");
		}

		path.append(viewUriTemplate.trim());
		return path.toString();
	}

	public String getResourceContextPath(String additionalUriTemplatePrefix,
			String resourceUriTemplate) {
		if ((resourceUriTemplate == null)
				|| (resourceUriTemplate.trim().length() == 0)) {
			return "";
		}

		StringBuilder path = new StringBuilder(request.getContextPath());
		path.append(RestmvcApplication.PATH);

		if ((additionalUriTemplatePrefix != null)
				&& (additionalUriTemplatePrefix.trim().length() > 0)
				&& !RestmvcApplication.URI_TEMPLATE_PREFIX_RESOURCE
						.equals(additionalUriTemplatePrefix.trim())) {
			if (!additionalUriTemplatePrefix.trim().startsWith("/")) {
				path.append("/");
			}

			path.append(additionalUriTemplatePrefix.trim());

			if (path.toString().endsWith("/")) {
				path.deleteCharAt(path.length() - 1);
			}
		}

		path.append(RestmvcApplication.URI_TEMPLATE_PREFIX_RESOURCE);

		if (!resourceUriTemplate.trim().startsWith("/")) {
			path.append("/");
		}

		path.append(resourceUriTemplate.trim());
		return path.toString();
	}
}
