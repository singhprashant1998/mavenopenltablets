package rules;




import java.time.LocalDateTime;

import org.openl.rules.runtime.RulesEngineFactory;
import org.openl.runtime.EngineFactory;
import model.Case;
import model.User;


public class Main {
    private IRule instance;

    public static void main(String[] args) {
        Main rules = new Main();
        User user = new User();
        user.setName("Prashant");
        Case aCase = new Case();
        aCase.setUser(user);
        aCase.setHourOfDay(23);
        rules.process(aCase);
    }

    public void process(Case aCase) {
        final EngineFactory<IRule> engineFactory = new RulesEngineFactory<IRule>(getClass().getClassLoader()
            .getResource("openltablets/HelloUser.xls"), IRule.class);
        instance = engineFactory.newEngineInstance();
        instance.helloUser(aCase, new Response());
    }
}
