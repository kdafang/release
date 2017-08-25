package io.renren.util;
import io.renren.service.ReleaseNewsService;

/**
 * Created by kdafang on 2017/8/25.
 */
public class DecideUitl {
    public AjaxResponse declideWebsite(AjaxResponse ajaxResponse, String website, ReleaseNewsService releaseNewsService) {
        if (website != null) {
            if (!releaseNewsService.existWebsite(website)) {
                ajaxResponse.setCode(4);
                ajaxResponse.setMessage("站点名称输入错误！");
            }

        }
        return ajaxResponse;
    }

    }
