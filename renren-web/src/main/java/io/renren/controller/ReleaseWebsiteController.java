package io.renren.controller;


import io.renren.service.ReleaseNewsService;
import io.renren.util.AjaxResponse;
import io.renren.util.JsonUitl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping(value = "/f/release/web")
public class ReleaseWebsiteController {

    @Autowired
    private ReleaseNewsService releaseNewsService;

    @RequestMapping(value = "getWebsiteList")
    public AjaxResponse getWebsiteList(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        List<HashMap> websiteList = releaseNewsService.getWebsiteList();
        JSONArray jsonArray = JsonUitl.getJson(websiteList);
        ajaxResponse.setData(jsonArray);
        return ajaxResponse;
    }

}
