package com.aem.geeks.core.models.impl;

import com.aem.geeks.core.models.HeaderModel;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = {Resource.class}, adapters = HeaderModel.class,resourceType = {
        "/apps/aemgeeks/components/content/header"},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderModelImpl implements HeaderModel {

    private static final Logger LOG = LoggerFactory.getLogger(HeaderModelImpl.class);

    @Inject
    //@Default(values = "/content/aemgeeks/us/en")
    Resource resource;

    @Inject
    ResourceResolver resourceResolver;
    @Inject
    @Via("resource")
    @Default(values = "/content/aemgeeks/us/en")
    String rootPath;

    @PostConstruct
    protected void init() {

        if (null != resource) {
            LOG.info("Current Resource Name-->{}", resource.getName());
        }else {
            LOG.info("Resource object is Null");
        }
    }

    @Override
    public String getPageTitle() {
        return (!(resource.getName().isEmpty()) ? resource.getName() : "Murali");
    }

    public String getChildPagesName(){
        Resource rootContentNode=resourceResolver.resolve(rootPath);
        LOG.info("Root Node Name->{}",rootContentNode.getName());
        LOG.info("Root Node has child nodes ->{}",rootContentNode.hasChildren());
        return "";
    }
}
