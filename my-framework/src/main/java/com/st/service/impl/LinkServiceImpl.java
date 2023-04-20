package com.st.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.st.constants.SystemConstants;
import com.st.domain.ResponseResult;
import com.st.domain.entity.Link;
import com.st.domain.vo.ListVo;
import com.st.mapper.LinkMapper;
import com.st.service.LinkService;
import com.st.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2022-03-04 14:43:52
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        //查询所有审核通过的
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> list = list(queryWrapper);

        //转换成vo
        List<ListVo> listVos = BeanCopyUtils.copyBeanList(list, ListVo.class);
        //封装返回
        return ResponseResult.okResult(listVos);
    }
}

