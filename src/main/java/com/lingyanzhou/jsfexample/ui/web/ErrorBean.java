package com.lingyanzhou.jsfexample.ui.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import org.primefaces.application.exceptionhandler.ExceptionInfo;
import org.apache.commons.lang.exception.ExceptionUtils;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@ApplicationScoped
public class ErrorBean {
  private static final String PF_ERROR_STATUS_CODE = "500";

  private ExceptionInfo getPfExceptionInfo() {
    FacesContext context = FacesContext.getCurrentInstance();
    ExceptionInfo info = (ExceptionInfo) context.getAttributes().get(ExceptionInfo.ATTRIBUTE_NAME);

    if (info == null) {
      info = (ExceptionInfo) context.getExternalContext().getSessionMap().get(ExceptionInfo.ATTRIBUTE_NAME);
    }

    return info;
  }

  public String getStatusCode(){
    Integer code = (Integer)FacesContext.getCurrentInstance().getExternalContext().
      getRequestMap().get("javax.servlet.error.status_code");
    if (null!=code) {
      return String.valueOf(code);
    } else if (null!=getPfExceptionInfo()) {
      return PF_ERROR_STATUS_CODE;
    } else {
      return null;
    }
  }

  public String getMessage(){
    String servletVal = (String)FacesContext.getCurrentInstance().getExternalContext().
      getRequestMap().get("javax.servlet.error.message");
    if (null!=servletVal) {
      return servletVal;
    } else {
      ExceptionInfo pfExceptionInfo = getPfExceptionInfo();
      if (null != pfExceptionInfo) {
        return pfExceptionInfo.getMessage();
      } else {
        return null;
      }
    }
  }

    public String getExceptionType(){
      Class exceptionType = (Class)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.exception_type");
      if (null!=exceptionType) {
        return exceptionType.toString();
      } else {
        ExceptionInfo pfExceptionInfo = getPfExceptionInfo();
        if (null != pfExceptionInfo) {
          return pfExceptionInfo.getType();
        } else {
          return null;
        }
      }
    }

    private Throwable getException(){
      Throwable ret = (Throwable)FacesContext.getCurrentInstance().getExternalContext().
        getRequestMap().get("javax.servlet.error.exception");
      if (null!=ret) {
        return ret;
      } else {
        ExceptionInfo pfExceptionInfo = getPfExceptionInfo();
        if (null != pfExceptionInfo) {
          return pfExceptionInfo.getException();
        } else {
          return null;
        }
      }
    }

  public String getRequestURI(){
    String ret = (String)FacesContext.getCurrentInstance().getExternalContext().
      getRequestMap().get("javax.servlet.error.request_uri");
    if (null!=ret) {
      return ret;
    } else {
      ExceptionInfo pfExceptionInfo = getPfExceptionInfo();
      if (null != pfExceptionInfo) {
        return (String)((HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest()).getRequestURI().toString();
      } else {
        return null;
      }
    }
  }

  public String getServletName(){
    String ret = (String)FacesContext.getCurrentInstance().getExternalContext().
      getRequestMap().get("javax.servlet.error.servlet_name");
    if (null!=ret) {
      return ret;
    } else {
      ExceptionInfo pfExceptionInfo = getPfExceptionInfo();
      if (null != pfExceptionInfo) {
        return "javax.faces.webapp.FacesServlet";
      } else {
        return null;
      }
    }
  }

  public String getStackTrace(){
    Throwable exception = getException();
    if (null!=exception) {
      return ExceptionUtils.getStackTrace(exception);
    } else {
      return null;
    }
  }
}
