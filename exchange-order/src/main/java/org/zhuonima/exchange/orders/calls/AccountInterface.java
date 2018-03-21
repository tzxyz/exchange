package org.zhuonima.exchange.orders.calls;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhuonima.exchange.common.domain.ApiResult;

@FeignClient("accounts")
public interface AccountInterface {

    @RequestMapping(method = RequestMethod.POST, value = "/freeze")
    ApiResult freeze();
}
