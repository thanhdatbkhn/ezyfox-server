package com.tvd12.ezyfoxserver.testing.context;

import java.util.Set;

import org.testng.annotations.Test;

import com.tvd12.ezyfoxserver.context.EzyServerContext;
import com.tvd12.ezyfoxserver.context.EzySimpleChildContext;
import com.tvd12.ezyfoxserver.testing.BaseCoreTest;
import com.tvd12.ezyfoxserver.util.EzyExceptionHandlers;
import com.tvd12.ezyfoxserver.util.EzyExceptionHandlersFetcher;
import com.tvd12.ezyfoxserver.util.EzyListExceptionHandlers;

public class EzySimpleChildContextTest extends BaseCoreTest {

    private EzyServerContext context;
    private EzySimpleChildContext ctx;

     public EzySimpleChildContextTest() {
         super();
         context = newServerContext();
         context.setProperty(Integer.class, 1);
         ctx = new ChildContext();
         ctx.setParent(context);
         ctx.setProperty(String.class, "a");
     }
     
     @Test
     public void test1() {
         assert ctx.getParent() == context;
     }
     
     @Test(expectedExceptions = {IllegalArgumentException.class})
     public void test2() {
         ctx.get(UnsafeCommand.class);
     }
     
     @Test
     public void test3() {
         assert ctx.get(String.class).equals("a");
         assert ctx.get(Integer.class).equals(1);
     }
     
     public static class ChildContext extends EzySimpleChildContext {
         
         @SuppressWarnings("rawtypes")
        @Override
        protected void addUnsafeCommands(Set<Class> unsafeCommands) {
             unsafeCommands.add(UnsafeCommand.class);
        }
         
        @Override
        protected EzyExceptionHandlersFetcher getExceptionHandlersFetcher() {
            return new EzyExceptionHandlersFetcher() {
                
                @Override
                public EzyExceptionHandlers getExceptionHandlers() {
                    return new EzyListExceptionHandlers();
                }
            };
        }

        @Override
        public void destroy() {
            
        }
     }
     
     public static class UnsafeCommand {
         
     }
}
