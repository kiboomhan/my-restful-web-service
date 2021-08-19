package com.example.restfulwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.LinkRelation;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.mediatype.hal.CurieProvider;
import org.springframework.hateoas.mediatype.hal.DefaultCurieProvider;
import org.springframework.hateoas.mediatype.hal.HalConfiguration;
import org.springframework.hateoas.mediatype.hal.HalConfiguration.RenderSingleLinks;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@Configuration
//@EnableWebMvc
@EnableHypermediaSupport(type= {HypermediaType.HAL_FORMS})
public class HalConf {

    @Bean
    public HalConfiguration globalPolicy() {
        return new HalConfiguration() //
                .withRenderSingleLinks(RenderSingleLinks.AS_ARRAY);
    }

    /*@Bean
    public HalConfiguration linkRelationBasedPolicy() {
        return new HalConfiguration() //
                .withRenderSingleLinksFor( //
                        IanaLinkRelations.ITEM, RenderSingleLinks.AS_ARRAY)
                .withRenderSingleLinksFor( //
                        LinkRelation.of("prev"), RenderSingleLinks.AS_SINGLE);
    }

    @Bean
    public HalConfiguration patternBasedPolicy() {
        return new HalConfiguration() //
                .withRenderSingleLinksFor( //
                        "http*", RenderSingleLinks.AS_ARRAY);
    }*/

    /*@Bean
    public CurieProvider curieProvider() {
        DefaultCurieProvider ex = new DefaultCurieProvider("ex", new org.springframework.hateoas.UriTemplate("http://localhost:8088/users/{rel}"));

        return ex;
    }*/
}
