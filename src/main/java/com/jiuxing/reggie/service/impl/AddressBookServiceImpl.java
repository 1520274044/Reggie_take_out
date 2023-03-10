package com.jiuxing.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiuxing.reggie.entity.AddressBook;
import com.jiuxing.reggie.mapper.AddressBookMapper;
import com.jiuxing.reggie.service.AddressBookService;
import org.springframework.stereotype.Service;

/**
 * @author 九幸
 * @email 1520274044@qq.com
 * @data 2023/3/9  16:32
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper , AddressBook>implements AddressBookService {
}
