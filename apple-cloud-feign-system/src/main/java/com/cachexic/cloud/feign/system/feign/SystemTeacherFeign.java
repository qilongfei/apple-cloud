package com.cachexic.cloud.feign.system.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.system.entity.Teacher;
import com.cachexic.cloud.feign.system.entity.query.TeacherQuery;
import com.cachexic.cloud.feign.system.feign.fallback.SystemTeacherFeignFallback;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description: 教师管理
 * @author tangmin
 * @date 2017-11-05 19:47:06
 */
@FeignClient(name = "provider-system", path = "/teacher", fallbackFactory = SystemTeacherFeignFallback.class)
public interface SystemTeacherFeign {

  /**
   * List
   * @param query
   */
  @PostMapping("list")
  Result<List<Teacher>> list(@RequestBody TeacherQuery query);

  /**
   * 分页查询
   * @param query
   */
  @PostMapping("pagination")
  Result<Pagination<Teacher>> pagination(@RequestBody TeacherQuery query);

  /**
   * 根据主键查询
   * @param id
   */
  @GetMapping("{id}")
  Result<Teacher> getById(@PathVariable("id") Long id);

  /**
   * 根据主键ids查询
   * @param ids
   */
  @GetMapping("ids/{ids}")
  Result<List<Teacher>> getByIds(@PathVariable("ids") String ids);

  /**
   * 新增方法
   * @param entity
   */
  @PostMapping
  Result save(@RequestBody Teacher entity);

  /**
   * 修改方法
   * @param entity
   */
  @PutMapping
  Result update(@RequestBody Teacher entity);

  /**
   * 根据Id删除
   * @param id
   */
  @DeleteMapping("{id}")
  Result deleteById(@PathVariable("id") Long id);

  /**
   * 根据ids删除，id逗号隔开
   * @param ids
   */
  @DeleteMapping("ids/{ids}")
  Result deleteByIds(@PathVariable("ids") String ids);
}
