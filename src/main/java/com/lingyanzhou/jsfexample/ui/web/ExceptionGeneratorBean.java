package com.lingyanzhou.jsfexample.ui.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@ViewScoped
public class ExceptionGeneratorBean {
  public String[] getExceptionNames() {
    String[] ret = new String[3];
    ret[0] = "NullPointerException";
    ret[1] = "IOException";
    ret[2] = "NumberFormatException";

    return ret;
  }

  @Getter @Setter
  private String exceptionName;

  public void listenerException() throws Exception {
    if ("NullPointerException".equals(exceptionName)) {
      throw new NullPointerException("NullPointerException generated.");
    } else if ("NumberFormatException".equals(exceptionName)) {
      throw new NumberFormatException("NumberFormatException generated.");
    } else if ("IOException".equals(exceptionName)) {
      throw new IOException("IOException generated.");
    }
  }

  public String actionException() throws Exception {

    if ("NullPointerException".equals(exceptionName)) {
      throw new NullPointerException("NullPointerException generated.");
    } else if ("NumberFormatException".equals(exceptionName)) {
      throw new NumberFormatException("NumberFormatException generated.");
    } else if ("IOException".equals(exceptionName)) {
      throw new IOException("IOException generated.");
    }
    return "";
  }

  public String getException() throws Exception {
    throw new IllegalStateException("IllegalStateException generated in getException.");   
  }

}
