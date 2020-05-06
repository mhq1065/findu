package org.bigdatahealth.findu.config;



//extends WebSecurityConfigurerAdapter
public class MySecurityConfig {


    /*@Autowired
    private MyUserDetails userDetails;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/api/**").permitAll()
                                .antMatchers("/admin/**").hasRole("ADMIN");


        //登录路径，对应LoginController中的signIn方法，我们可以在这个方法中添加我们在进入登录页面前的一些逻辑
//        http.formLogin().loginPage("/signIn")
//        //跳转到login页面，登录成功后默认跳转到index
//        .loginProcessingUrl("/login").defaultSuccessUrl("/index",true)
//        //登录失败跳转页面
//        .failureUrl("/signIn?error").permitAll()
//        //失效session跳转路径
//        .and().sessionManagement().invalidSessionUrl("/signIn")
//        //session失效时间
//        .and().rememberMe().tokenValiditySeconds(1209600)
//        //掉线之后的跳转路径
//        .and().logout().logoutSuccessUrl("/signIn").permitAll()
//        .and().csrf().disable();
        http.formLogin().loginPage("/signIn").successForwardUrl("/admin/index");
        http.rememberMe();
    }

    *//**
     * 定义解码器
     * *//*
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    *//**定义认证用户信息获取来源，密码校验规则等*//*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        *//**有以下几种形式，使用第3种*//*
        //inMemoryAuthentication 从内存中获取
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN");

        //jdbcAuthentication从数据库中获取，但是默认是以security提供的表结构
        //usersByUsernameQuery 指定查询用户SQL
        //authoritiesByUsernameQuery 指定查询权限SQL
        //auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(query).authoritiesByUsernameQuery(query);

        //注入userDetailsService，需要实现userDetailsService接口

        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());
    }
*/
}
