package com.cachexic.cloud.web.backstage.controller.eshop;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.eshop.entity.Eshop;
import com.cachexic.cloud.feign.eshop.entity.query.EshopQuery;
import com.cachexic.cloud.feign.eshop.feign.EshopFeign;
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
 * @Description: e店管理  /eshop
 * @author tangmin
 * @date 2017-10-10 21:00:52
 */
@Api(description = "e店管理")
@RestController
@RequestMapping("/eshop")
public class EshopWebController{

  @Autowired
  private EshopFeign eshopFeign;

  @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
  @PostMapping("list")
  public Result<List<Eshop>> list(@RequestBody EshopQuery query){
    return eshopFeign.list(query);
  }

  @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
  @PostMapping("pagination")
  public Result<Pagination<Eshop>> pagination(@RequestBody EshopQuery query){
    return eshopFeign.pagination(query);
  }

  @ApiOperation("getById:根据主键查询")
  @GetMapping("{id}")
  public Result<Eshop> getById(@PathVariable("id") Long id){
    return eshopFeign.getById(id);
  }

  @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
  @GetMapping("ids/{ids}")
  public Result<List<Eshop>> getByIds(@PathVariable("ids") String ids){
    return eshopFeign.getByIds(ids);
  }

  @ApiOperation("save:新增方法")
  @PostMapping
  public Result save(@RequestBody Eshop entity){
    return eshopFeign.save(entity);
  }

  @ApiOperation("update:修改方法")
  @PutMapping
  public Result update(@RequestBody Eshop entity){
    return eshopFeign.update(entity);
  }

  @ApiOperation("deleteById:根据Id删除")
  @DeleteMapping("{id}")
  public Result deleteById(@PathVariable("id") Long id){
    return eshopFeign.deleteById(id);
  }

  @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
  @DeleteMapping("ids/{ids}")
  public Result deleteByIds(@PathVariable("ids") String ids){
    return eshopFeign.deleteByIds(ids);
  }
}
