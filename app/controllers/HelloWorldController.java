
package controllers;
import play.mvc.Controller;
import play.mvc.Result;

public class HelloWorldController extends Controller {

    public Result HelloWorld(){
        return ok( "sanjana");
    }

    public Result helloSanjana() {
        return ok("sanjana" + " says " + "hello");
    }

    public Result hello(String name) {
        return ok("HELOO" + name +"!");
    }
    public Result hellos(String name ,Integer count) {
        final StringBuffer sb = new StringBuffer();
        sb.append("Hello");
        for (int i =0;i<count;i++) {
            sb.append(name + " ");
        }
        sb.append("!");
        return ok(sb.toString());

    }
    public Result greetings() {

        return ok();

    }
}
