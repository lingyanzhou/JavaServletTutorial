package com.lingyanzhou.jsfexample.ui.web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.Serializable;

@ManagedBean
@ViewScoped
public class HelloBean implements Serializable {

  private static final Logger logger = LoggerFactory.getLogger(HelloBean.class);


  private String name;

  public String getName() {
    logger.debug("getName()");
    return name;
  }

  public void setName(String name) {
    logger.debug("setName(String name) with name="+name);

    this.name = name;
  }

}
