package com.cachexic.cloud.web.backstage.controller.test;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.feign.order.entity.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author tangmin
 * @date 2017-10-19 16:13:18
 */
@RestController
@RequestMapping("/test")
public class TestController {

  @GetMapping("{id}")
  public Result<Teacher> getById(@PathVariable("id") Long id) {
    User user = new User();
    user.setId(id);
    user.setName("zhangsan");
    user.setAvatar(
        "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif?imageView2/1/w/80/h/80");
    return Result.OK("success").setData(user);
  }
}
