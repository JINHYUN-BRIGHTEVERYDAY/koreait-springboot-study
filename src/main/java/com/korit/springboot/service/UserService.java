package com.korit.springboot.service;

import com.korit.springboot.dto.CreateUserReqDto;
import com.korit.springboot.entity.UserEntity;
import com.korit.springboot.exception.DuplicationException;
import com.korit.springboot.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.lang.reflect.Method;

@Service
@RequiredArgsConstructor
public class UserService {


//    @Autowired
    private final UserMapper userMapper;


    @Transactional(rollbackFor = Exception.class)
    public int createUser(CreateUserReqDto createUserReqDto) {
        UserEntity userEntity = createUserReqDto.userEntity();
        System.out.println(userEntity);
        userMapper.insert(createUserReqDto.userEntity());
        System.out.println(userEntity);
        return userEntity.getUserId();
    }


    public void duplicatedUsername(String username) throws MethodArgumentNotValidException {
        UserEntity foundUser = userMapper.findUserByUsername(username);
//        if (foundUser != null) {
//            MethodParameter methodParameter = new MethodParameter(this.getClass().getMethod("duplicatedUsername", String.class), 0);
//            BindingResult bindingResult = new BeanPropertyBindingResult(foundUser, "");
//            FieldError fieldError = new FieldError("username", "username", "이미 사용중인 사용자이름입니다");
//            bindingResult.addError(fieldError);
//            throw new MethodArgumentNotValidException(methodParameter, bindingResult);
//        }

        if (foundUser != null) {
            throw new DuplicationException("username", "이미 존재하는 사용자이름입니다");
        }

    }

}
