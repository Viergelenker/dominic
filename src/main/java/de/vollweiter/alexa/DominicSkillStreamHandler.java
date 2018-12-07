package de.vollweiter.alexa;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class DominicSkillStreamHandler extends SkillStreamHandler
{
    private static Skill getSkill() {
        return Skills.standard()
        .addRequestHandlers(
        new LaunchRequestHandler(),
        new CancelStopIntentHandler())
        .build();
    }

    public DominicSkillStreamHandler() {
        super(getSkill());
    }
}
