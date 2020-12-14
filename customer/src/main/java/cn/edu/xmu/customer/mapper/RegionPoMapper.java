package cn.edu.xmu.customer.mapper;

import cn.edu.xmu.customer.model.po.RegionPo;
import cn.edu.xmu.customer.model.po.RegionPoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    long countByExample(RegionPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int deleteByExample(RegionPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int insert(RegionPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int insertSelective(RegionPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    List<RegionPo> selectByExample(RegionPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    RegionPo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RegionPo record, @Param("example") RegionPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RegionPo record, @Param("example") RegionPoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RegionPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table region
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RegionPo record);
}