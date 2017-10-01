package com.cachexic.cloud.web.backstage.controller.order;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理  /order
 *
 * @author tangmin
 * @date 2017-09-28 12:51:58
 */
@Api(description = "订单管理")
@RestController
@RequestMapping("/order")
public class OrderWebController {

  @Autowired
  private OrderFeign orderFeign;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @PostMapping("list")
  public Result<List<Order>> list(@RequestBody OrderQuery query) {
    return orderFeign.list(query);
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @PostMapping("pagination")
  public Result<Pagination<Order>> pagination(@RequestBody OrderQuery query) {
    return orderFeign.pagination(query);
  }

  @ApiOperation("getById:根据主键查询")
  @GetMapping("{id:\\d+}")
  public Result<Order> getById(@PathVariable("id") Long id) {
    return orderFeign.getById(id);
  }

  @ApiOperation(value = "getByIds:根据主键ids查询", notes = "逗号分隔")
  @GetMapping("ids/{ids}")
  public Result<List<Order>> getByIds(@PathVariable("ids") String ids) {
    return orderFeign.getByIds(ids);
  }

  @ApiOperation("save:新增方法")
  @PostMapping
  public Result save(@RequestBody Order entity) {
    return orderFeign.save(entity);
  }

  @ApiOperation("update:修改方法")
  @PutMapping
  public Result update(@RequestBody Order entity) {
    return orderFeign.update(entity);
  }

  @ApiOperation("deleteById:根据Id删除")
  @DeleteMapping("{id:\\d+}")
  public Result deleteById(@PathVariable("id") Long id) {
    return orderFeign.deleteById(id);
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除", notes = "逗号分隔")
  @DeleteMapping("ids/{ids}")
  public Result deleteByIds(@PathVariable("ids") String ids) {
    return orderFeign.deleteByIds(ids);
  }
}
