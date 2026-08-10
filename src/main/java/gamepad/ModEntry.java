package gamepad;

import arc.*;
import arc.input.*;
import arc.util.*;
import mindustry.mod.*;

public class ModEntry extends Mod {
    @Override
    public void init() {
        Events.run(Trigger.update, () -> {
            Gamepad pad = Input.getGamepad(0);
            if (pad == null) return;

            float deadZone = 0.15f;
            float speed = 4.5f;

            float xAxis = pad.getAxis(GamepadAxis.leftStickX);
            float yAxis = pad.getAxis(GamepadAxis.leftStickY);

            if (Math.abs(xAxis) > deadZone) {
                Core.camera.position.x += xAxis * speed;
            }
            if (Math.abs(yAxis) > deadZone) {
                Core.camera.position.y += yAxis * speed;
            }

            if (pad.isButtonPressed(Gamepad.Button.a)) {
                Log.info("A键触发");
            }
            if (pad.isButtonPressed(Gamepad.Button.b)) {
                Log.info("B键触发");
            }
        });
    }
}