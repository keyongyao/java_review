package com.example.jsEngineRhino;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by Administrator on 2016/8/14.
 */
public class Main {
    public static void main(String[] args) {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("js");
        engine.put("msg", "abcdefg");
        // js 脚本
        String js = "var  user={name:'kyy',age:'23',school:['sizhong','zhongshan']};";
        js += "print(user.name);";
        try {
            engine.eval(js);
            //书写JS函数和调用函数
            engine.eval("function add(a,b){var sum=a+b;return sum ;}");
            Invocable invocable = (Invocable) engine;
            Object re = invocable.invokeFunction("add", new Object[]{23, 45});
            System.out.println(re);

        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }
}
