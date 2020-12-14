package cn.edu.xmu.customer.controller;

import cn.edu.xmu.customer.model.vo.ModifyPwdVo;
import cn.edu.xmu.customer.model.vo.ResetPwdVo;
import cn.edu.xmu.ooad.util.JacksonUtil;
import cn.edu.xmu.ooad.util.JwtHelper;
import cn.edu.xmu.ooad.util.ResponseCode;
import cn.edu.xmu.customer.model.vo.LoginVo;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class CustomerControllerTest {
    @Autowired
    private MockMvc mvc;
    private static final Logger logger = LoggerFactory.getLogger(CustomerControllerTest.class);
    private final String creatTestToken(Long userId, Long departId, int expireTime) {
        String token = new JwtHelper().createToken(userId, departId, expireTime);
        logger.debug(token);
        return token;
    }

    /*
    获取所有状态
     */

@Test
    public void getAllStateTest()throws Exception{

    String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(get("/user/users/states").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{ \"errno\": 0, \"data\": [ { \"name\": \"后台\", \"code\": 0 }, { \"name\": \"正常\", \"code\": 4 }, { \"name\": \"封禁\", \"code\": 6 } ], \"errmsg\": \"成功\" }";
        JSONAssert.assertEquals(expectedResponse,responseString,true);
    }
/*
注册新用户（正常）
 */
    @Test
    public void reigsterTest1()throws Exception{
      String requireJson="{\n" +
              "  \"mobile\": \"13950004260\",\n" +
              "  \"email\": \"1309379909@qq.com\",\n" +
              "  \"userName\": \"xskxsk\",\n" +
              "  \"password\": \"000105\",\n" +
              "  \"realName\": \"xsk\",\n" +
              "  \"gender\": 0,\n" +
              "  \"birthday\": \"2000-01-05\"\n" +
              "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isCreated())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{" +
                "\"errno\": 0," +
                "\"data\": {" +
                //"\"id\": 17363," +
                "\"userName\": \"xskxsk\"," +
                "\"name\": \"xsk\"," +
                "\"mobile\": \"13950004260\"," +
                "\"email\": \"1309379909@qq.com\"," +
                "\"gender\": \"0\"," +
                "\"birthday\": \"2000-01-05\"," +
                "\"state\": 4,"+
                //"\"gmtCreate\": \"2020-12-04T14:20:24\"," +
                "\"gmtModified\": null" +
                "}," +
                "\"errmsg\": \"成功\"" +
                "}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }

    /*
    注册新用户（用户名已注册）
     */
    @Test
    public void registerTest2()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"13950004260\",\n" +
                "  \"email\": \"1309339990@qq.com\",\n" +
                "  \"userName\": \"59460469111\",\n" +
                "  \"password\": \"000105\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.USER_NAME_REGISTERED.getCode()))
                .andExpect(jsonPath("$.errmsg").value("用户名已被注册"))
                .andReturn().getResponse().getContentAsString();
    }
    /*
        注册新用户（电话已注册）
         */
    @Test
    public void registerTest4()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"13959288883\",\n" +
                "  \"email\": \"1309339990@qq.com\",\n" +
                "  \"userName\": \"xskxsk\",\n" +
                "  \"password\": \"000105\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.MOBILE_REGISTERED.getCode()))
                .andExpect(jsonPath("$.errmsg").value("电话已被注册"))
                .andReturn().getResponse().getContentAsString();
    }
    /*
    注册新用户（邮箱已被注册）
     */
    @Test
    public void registerTest3()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"13950004260\",\n" +
                "  \"email\": \"1309339909@qq.com\",\n" +
                "  \"userName\": \"xskxsk\",\n" +
                "  \"password\": \"0105Xsk;\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.EMAIL_REGISTERED.getCode()))
                .andExpect(jsonPath("$.errmsg").value("邮箱已被注册"))
                .andReturn().getResponse().getContentAsString();
    }
    /*
        注册新用户（用户名格式不正确）
         */
    @Test
    public void registerTest5()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"13950004260\",\n" +
                "  \"email\": \"xiangshuke@qq.com\",\n" +
                "  \"userName\": \"xsk\",\n" +
                "  \"password\": \"0105Xsk..\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":503,\"errmsg\":\"用户名长度过短;\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }
    /*
        注册新用户（邮箱格式不正确）
         */
    @Test
    public void registerTest6()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"13950004260\",\n" +
                "  \"email\": \"xiangshukeqq.com\",\n" +
                "  \"userName\": \"xskxsk\",\n" +
                "  \"password\": \"0105Xsk..\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":503,\"errmsg\":\"email格式不正确;\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }
    /*
    注册新用户（手机号格式不正确）
     */
    @Test
    public void registerTest7()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"1abc394260\",\n" +
                "  \"email\": \"1309339909@qq.com\",\n" +
                "  \"userName\": \"xskxsk\",\n" +
                "  \"password\": \"0105Xsk..\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":503,\"errmsg\":\"手机号格式不正确;\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }
    /*
    注册新用户（密码格式不正确）

    @Test
    public void registerTest8()throws Exception{
        String requireJson="{\n" +
                "  \"mobile\": \"1abc394260\",\n" +
                "  \"email\": \"1309339909@qq.com\",\n" +
                "  \"userName\": \"xskxsk\",\n" +
                "  \"password\": \"0105xsk\",\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": 0,\n" +
                "  \"birthday\": \"2000-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(post("/user/users")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":503,\"errmsg\":\"密码格式不正确;\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }
    */
    /*
    平台管理员封禁买家(正常）
*/
     @Test
    public void banCustomerTest1()throws Exception{
         String token = creatTestToken(1L, 0L, 100);
         String responseString=this.mvc.perform(put("/users/2/ban").header("authorization", token))
                         .andExpect(status().isOk())
                         .andExpect(content().contentType("application/json;charset=UTF-8"))
                         .andExpect(jsonPath("$.errno").value(ResponseCode.OK.getCode()))
                         .andExpect(jsonPath("$.errmsg").value("成功"))
                         .andReturn().getResponse().getContentAsString();
     }

     /*
     平台管理员封禁买家(id不存在）
      */
    @Test
     public void banCustomerTest2()throws Exception{
         String token = creatTestToken(1L, 0L, 100);
         String responseString=this.mvc.perform(put("/user/users/0/ban").header("authorization", token))
                 .andExpect(status().isNotFound())
                 .andExpect(content().contentType("application/json;charset=UTF-8"))
                 .andExpect(jsonPath("$.errno").value(ResponseCode.RESOURCE_ID_NOTEXIST.getCode()))
                 .andExpect(jsonPath("$.errmsg").value("操作的资源id不存在"))
                 .andReturn().getResponse().getContentAsString();
     }

    /*
    平台管理员封禁买家(用户已被逻辑删除）
    */
    @Test
    public void banCustomerTest3()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(put("/user/users/1/ban").header("authorization", token))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.RESOURCE_ID_NOTEXIST.getCode()))
                .andExpect(jsonPath("$.errmsg").value("操作的资源id不存在"))
                .andReturn().getResponse().getContentAsString();
    }

    /*
   平台管理员封禁买家(无权限）
*/
    @Test
    public void banCustomerTest4()throws Exception{
        String token = creatTestToken(1L, -2L, 100);
        String responseString=this.mvc.perform(put("/user/users/2/ban").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.FIELD_NOTVALID.getCode()))
                .andExpect(jsonPath("$.errmsg").value("没有权限"))
                .andReturn().getResponse().getContentAsString();
    }
    /*
   平台管理员解禁买家(正常）
*/
    @Test
    public void releaseCustomerTest1()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(put("/user/users/2/release").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.OK.getCode()))
                .andExpect(jsonPath("$.errmsg").value("成功"))
                .andReturn().getResponse().getContentAsString();
    }

    /**
     * 平台管理员解禁买家(用户id不存在）
     * @throws Exception
     */
    @Test
    public void releaseCustomerTest2()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(put("/user/users/0/release").header("authorization", token))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.RESOURCE_ID_NOTEXIST.getCode()))
                .andExpect(jsonPath("$.errmsg").value("操作的资源id不存在"))
                .andReturn().getResponse().getContentAsString();
    }
    /**
     * 平台管理员解禁买家(用户已被逻辑删除）
     * @throws Exception
     */
    @Test
    public void releaseCustomerTest3()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(put("/user/users/1/release").header("authorization", token))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.errno").value(ResponseCode.RESOURCE_ID_NOTEXIST.getCode()))
                .andExpect(jsonPath("$.errmsg").value("操作的资源id不存在"))
                .andReturn().getResponse().getContentAsString();
    }
    /**
     * 登陆（正常）
     * @throws Exception
     */
    @Test
    public void loginTest()throws Exception{
        LoginVo loginVo=new LoginVo();
        loginVo.setUserName("59460469111");
        loginVo.setPassword("123456");
        String requireJson = JacksonUtil.toJson(loginVo);
        String responseString=this.mvc.perform(post("/user/users/login")
                         .contentType("application/json;charset=UTF-8")
                         .content(requireJson)).andExpect(status().isOk())
                         .andExpect(status().isOk())
                         .andExpect(content().contentType("application/json;charset=UTF-8"))
                         .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }
    /**
     * 登陆（密码不正确）
     * @throws Exception
     */
    @Test
    public void loginTest2()throws Exception{
        LoginVo loginVo=new LoginVo();
        loginVo.setUserName("59460469111");
        loginVo.setPassword("123457");
        String requireJson = JacksonUtil.toJson(loginVo);
        String responseString=this.mvc.perform(post("/user/users/login")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.errno").value(ResponseCode.AUTH_INVALID_ACCOUNT.getCode()))
                .andExpect(jsonPath("$.errmsg").value("用户名不存在或者密码错误"))
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
    }

    @Test
    public void getUserSelfTest()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(get("/user/users").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"data\":{\"id\":1,\"userName\":\"59460469111\",\"name\":\"49741965112\",\"mobile\":\"13959288888\",\"email\":\"1309339909@qq.com\",\"gender\":\"0\",\"birthday\":\"2020-12-24\",\"state\":1,\"gmtCreate\":\"2020-12-06T22:49:24\",\"gmtModified\":\"2020-12-06T22:49:24\"},\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }

    /*
    管理员获取用户信息（正常）
     */
    @Test
    public void getCustomerByIdTest()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String responseString=this.mvc.perform(get("/user/users/1").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"data\":{\"id\":1,\"userName\":\"59460469111\",\"name\":\"49741965112\",\"mobile\":\"13959288888\",\"email\":\"1309339909@qq.com\",\"gender\":\"0\",\"birthday\":\"2020-12-24\",\"state\":1,\"gmtCreate\":\"2020-12-06T22:49:24\",\"gmtModified\":\"2020-12-06T22:49:24\"},\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }

    @Test
    public void updateCustomerInfo()throws Exception{
        String token = creatTestToken(1L, -2L, 100);
        String requireJson="{\n" +
                "  \"realName\": \"xsk\",\n" +
                "  \"gender\": \"1\",\n" +
                "  \"birthday\": \"2020-01-05\"\n" +
                "}";
        String responseString=this.mvc.perform(put("/user/users").header("authorization", token)
                .contentType("application/json;charset=UTF-8")
                .content(requireJson)).andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,true);
    }

    @Test
    public void getCustomerAllTest()throws Exception{
        String token = creatTestToken(1L, 0L, 100);
        String expectedResponse=new String(Files.readAllBytes(Paths.get("src/test/java/resources/findAllCustomerSuccess.json")));
        String responseString = this.mvc.perform(get("/user/users/all?userName=&email=&mobile=13959288883&page=1&pageSize=2").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }

    @Test
    public void resetPwdTest()throws Exception{
        ResetPwdVo vo=new ResetPwdVo();
        vo.setUserName("jxljxljxl");
        vo.setEmail("835736795@qq.com");
        String requireJson = JacksonUtil.toJson(vo);
        String responseString=this.mvc.perform(put("/user/users/password/reset")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }

    @Test
    public void modifyPwdTest()throws Exception{
        ModifyPwdVo vo=new ModifyPwdVo();
        vo.setCaptcha("jn7MuC");
        vo.setNewPassword("jxl1234!");
        String requireJson = JacksonUtil.toJson(vo);
        String responseString=this.mvc.perform(put("/user/users/password")
                .contentType("application/json;charset=UTF-8")
                .content(requireJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }

    @Test
    public void logoutTest()throws Exception{
        String token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0aGlzIGlzIGEgdG9rZW4iLCJhdWQiOiJNSU5JQVBQIiwidG9rZW5JZCI6IjIwMjAxMjEyMjEwMjE4NzJWIiwiaXNzIjoiT09BRCIsImRlcGFydElkIjotMiwiZXhwIjoxNjA3NzgxNzM4LCJ1c2VySWQiOjEsImlhdCI6MTYwNzc3ODEzOH0.JlX_1MAYVsjHrkRYX-62jijPAK-2V4Rf0nfQAR_uP_o";
       String responseString = this.mvc.perform(get("/user/users/logout").header("authorization", token))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        String expectedResponse="{\"errno\":0,\"errmsg\":\"成功\"}";
        JSONAssert.assertEquals(expectedResponse,responseString,false);
    }
}
