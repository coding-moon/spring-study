package com.example.ex01.controller;

import com.example.ex01.domain.ProductVO;
import com.example.ex01.domain.TaskVO;
import com.example.ex01.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @RequestMapping(value = "ex01", method = RequestMethod.GET)
    public String ex01(){
        log.info("ex01..............");
        return "ex01";
    }

    @GetMapping("ex02")
    public void ex02(){
        log.info("ex02..............");
    }

    @GetMapping("ex03")
    public void ex03(HttpServletRequest request){
        String name = request.getParameter("name");
        log.info(name);
    }

    @GetMapping("ex04")
    public String ex04(String name, Model model){
       // model.addAttribute();
        log.info(name);
        return "/ex/ex04?name=" + name;
    }

//    이름, 나이 성별 받고 출력
    @GetMapping("ex05")
    public void ex04(String name, int age, String gender){
     log.info("이름 : " + name);
     log.info("나이 : " + age);
     log.info("성별 : " + gender);
    }

//    @GetMapping("ex06")
//    public void ex06(Human human){
//        log.info("이름 : "  + human.getName());
//        log.info("나이 : " + human.getAge());
//        log.info("성별 : " + human.getGender());
//
//    }

    @GetMapping("ex06")
    public void ex06(Human human ,@RequestParam("address") String city, Model model){
        log.info("이름 : "  + human.getName());
        log.info("나이 : " + human.getAge());
        log.info("성별 : " + human.getGender());
        log.info("성별 : " + city);

    }

    @GetMapping("ex07")
    public void ex078(Human human, @RequestParam("address") String city){
        log.info("이름 : "  + human.getName());
        log.info("나이 : " + human.getAge());
        log.info("성별 : " + human.getGender());
        log.info("사는 곳 : " + city);
    }

    //    [실습 1]
//    외부에서 상품명, 상품가격, 상품재고, 브랜드 전달받아서 화면에 전송
//    화면에서 4개 정보 입력 후 form태그로 전송한다.
    @GetMapping("task01_result")
    public void task01(ProductVO productVO) {

    }

    @GetMapping("task01")
    public void task01() {}

//    @PostMapping("register")
//    public RedirectView registerProduct(ProductVO productVO, RedirectAttributes redirectAttributes){
////        forward   : 그냥 리턴, .html로 즉시 이동
////        redirect  : RedirectView객체로 리턴, 생성자에 원하는 컨트롤러의 경로 작성, 컨트롤러에서 다시 Mapping
//
////        addAttribute() : URL뒤에 쿼리스트링을 붙여준다, 컨트롤러의 매개변수로 전달할 때 사용한다.
//
////        redirectAttributes.addAttribute("productName", productVO.getProductName());
////        redirectAttributes.addAttribute("productPrice", productVO.getProductPrice());
////        redirectAttributes.addAttribute("productStock", productVO.getProductStock());
////        redirectAttributes.addAttribute("productBrand", productVO.getProductBrand());
//
////        addFlashAttribute() : Flash 영역을 사용하여, 화면에 데이터를 전달할 때 사용한다.
//        redirectAttributes.addFlashAttribute(productVO);
//        return new RedirectView("/ex/list");
//    }

//    입력받은 상품명 수정 후 목록으로 출력



  /*  @GetMapping("list")
    public String list(ProductVO productVO){
        return "/product/list";
    }*/

    // addAttribute : URL뒤에 쿼리스트링을 붙여준다, 컨트롤러의 매개변수로 전달할 떄 사용한다
    // flash 컨트롤러 에서는 사용못함

//    [실습 2]
//    TaskVO 선언
//    int num, int kor, int eng, int math 선언
//    총점과 평균 점수 화면에 출력
//        @GetMapping("ex08")
//        public void ex08(TaskVO taskVO) {
//          log.info("총점" + (taskVO.getEng() + taskVO.getKor() + taskVO.getMath()));
//          log.info("평균" + (taskVO.getEng() + taskVO.getKor() + taskVO.getMath())/3);
//        }
   /* @PostMapping("score")
   public RedirectView score(Model model) {
        model.addAttribute(new TaskVO());
        return ""
    }

    @PostMapping("score")
    public RedirectView score(TaskVO taskVO, RedirectAttributes redirectAttributes) {
        (new TaskVO());
        return ""
    }*/

//    [실습 3]
//    아이디와 비밀번호를 입력받은 후 아이디가 admin일 경우 admin.html로 이동
//    아이디가 user일 경우 user.html로 이동
    @GetMapping("login")
    public void login() {;}

    @GetMapping("admin")
    public void admin() {;}

    @GetMapping("user")
    public void user() {;}

    @GetMapping("loginOk")
        public String loginOk (UserVO userVO) {

        String g = null;
        if(userVO.getUserId().equals("admin")) {
            g = "ex/admin";

        } else if (userVO.getUserId().equals("user")) {
            g = "ex/user";
        }
        return g;
    }
//
//    - login.html : 아이디와 비밀번호 입력 페이지 출력
//    - admin.html : 관리자 페이지 출력
//    - user.html : 일반 회원 페이지 출력


//    [실습 4]
//    이름을 입력하고 출근 또는 퇴근 버튼을 클릭한다.
//    출근 시간은 09:00이며, 퇴근 시간은 17:00이다.
//    출근 버튼 클릭 시 9시가 넘으면 지각으로 처리하고,
//    퇴근 버튼 클릭 시 17시 전이라면 퇴근이 아닌 업무시간으로 처리한다.
//    - getToWork.html //출근시간
//    - leaveWork.html //퇴근시간
//    - late.html // 지각
//    - work.html // 업무

    @GetMapping("form")
    public void form() {;}

    @GetMapping("getToworkOk")
        public String  getTowork () {
        String result = null;

        Calendar c1 = Calendar.getInstance();

          int s = c1.get(Calendar.HOUR_OF_DAY);
         result = s > 9 ? "/ex/late" : "/ex/getTowork";

        return result;

    }


@GetMapping("leaveOk")
    public String leaveWork () {
        String result  = null;

    Calendar c2 = Calendar.getInstance();

    int s = c2.get(Calendar.HOUR_OF_DAY);
    result = s  < 17 ? "/ex/work" : "/ex/leave";

    return result ;
}

}