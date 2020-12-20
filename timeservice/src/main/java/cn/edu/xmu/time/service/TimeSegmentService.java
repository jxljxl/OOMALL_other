package cn.edu.xmu.time.service;

import cn.edu.xmu.goods.service.GoodsServiceInterface;
import cn.edu.xmu.ooad.model.VoObject;
import cn.edu.xmu.ooad.util.ResponseCode;
import cn.edu.xmu.ooad.util.ReturnObject;

import cn.edu.xmu.other.service.AdServiceInterface;
import cn.edu.xmu.time.dao.TimeSegmentDao;
import cn.edu.xmu.time.model.bo.TimeSegment;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TimeSegmentService {
    private Logger logger = LoggerFactory.getLogger(TimeSegmentService.class);
    @Autowired
    TimeSegmentDao timeSegmentDao;

    @DubboReference(version = "0.0.1")
    AdServiceInterface iAdService;

    @DubboReference(version = "0.0.1")
    GoodsServiceInterface iGoodsService;

    public ReturnObject<PageInfo<VoObject>> selectAdTimeSegments(Integer pageNum, Integer pageSize)
    {
        ReturnObject<PageInfo<VoObject>> returnObject = timeSegmentDao.selectAdTimeSegments(pageNum, pageSize);
        return returnObject;
    }

    /**
     * 新增广告时段
     * @author zwl
     * @param
     * @return ReturnObject<VoObject> 时间段返回视图
     */
    @Transactional
    public ReturnObject insertAdTimeSegment(TimeSegment timeSegment)
    {
        timeSegment.setType((byte)0);
        timeSegment.setGmtCreate(LocalDateTime.now());
        ReturnObject<TimeSegment> retObj = timeSegmentDao.insertAdTimeSegment(timeSegment);
        return retObj;
//        ReturnObject<VoObject> retTimeSegment = null;
//        if (retObj.getCode().equals(ResponseCode.OK)) {
//            retTimeSegment = new ReturnObject<>(retObj.getData());
//        } else {
//            retTimeSegment = new ReturnObject<>(retObj.getCode(), retObj.getErrmsg());
//        }
//        return retTimeSegment;
    }

    /**
     *  * 删除广告时间段
     * @author zwl
     *  @param id 时间段id
     *  @return ReturnObject<Object> 返回视图
     */
    @Transactional
    public ReturnObject<Object> deleteAdTimeSegment(Long id) {
        //return timeSegmentDao.deleteAdTimeSegment(id);

        ReturnObject ret = timeSegmentDao.deleteAdTimeSegment(id);

        if(ret.getCode().equals(ResponseCode.OK))
        {
            boolean updateAd;
            updateAd=iAdService.updateAdSegId(id);
            if(updateAd)
            {return ret;}
            //修改对应广告的时间段失败
            else {return new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR);}
        }
        else
        {
            return ret;
        }
    }

    /**
     * 获取秒杀时间段
     * @author zwl
     * @param
     * @return
     * @Date:  2020/12/17 20:27
     */

    public ReturnObject<PageInfo<VoObject>> selectFlTimeSegments(Integer pageNum, Integer pageSize)
    {
        ReturnObject<PageInfo<VoObject>> returnObject = timeSegmentDao.selectFlTimeSegments(pageNum, pageSize);
        return returnObject;
    }

    /**
     * 新增秒杀时段
     * @author zwl
     * @param
     * @return ReturnObject<VoObject> 时间段返回视图
     */
    @Transactional
    public ReturnObject insertFlTimeSegment(TimeSegment timeSegment)
    {
        timeSegment.setType((byte)1);
        timeSegment.setGmtCreate(LocalDateTime.now());
        ReturnObject<TimeSegment> retObj = timeSegmentDao.insertFlTimeSegment(timeSegment);
        return retObj;

//        timeSegment.setType((byte)1);
//        timeSegment.setGmtCreate(LocalDateTime.now());
//        ReturnObject<TimeSegment> retObj = timeSegmentDao.insertFlTimeSegment(timeSegment);
//        ReturnObject<VoObject> retTimeSegment = null;
//        if (retObj.getCode().equals(ResponseCode.OK)) {
//            retTimeSegment = new ReturnObject<>(retObj.getData());
//        } else {
//            retTimeSegment = new ReturnObject<>(retObj.getCode(), retObj.getErrmsg());
//        }
//        return retTimeSegment;
    }

    /**
     *  * 删除时间段
     * @author zwl
     *  @param id 时间段id
     *  @return ReturnObject<Object> 返回视图
     */
    @Transactional
    public ReturnObject<Object> deleteFlTimeSegment(Long id) {

        ReturnObject ret = timeSegmentDao.deleteFlTimeSegment(id);

        return ret;
//        if(ret.getCode().equals(ResponseCode.OK))
//        {
//            boolean updateFl;
//            updateFl=iGoodsService.setFlashSaleSegId(id);
//            if(updateFl)
//            {return ret;}
//            //修改对应秒杀的时间段失败
//            else {return new ReturnObject<>(ResponseCode.INTERNAL_SERVER_ERR);}
//        }
//        else
//        {
//            return ret;
//        }
    }

}
