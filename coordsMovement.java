package org.firstinspires.ftc.teamcode.Utils;

public class coordsMovement {

    Movement movement = new Movement();

    public void Secuence(double[][] coords, double maxPower){


        for (int i  = 0; i <= coords.length; i += 1){
            double catetoB = coords[i][1] - coords[i + 1][1];
            double catetoA = coords[i][0] - coords[i + 1][0];
            double distancia = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));
            double angle = Math.atan2(catetoA, catetoB);

            if (coords[i + 1][1] < coords[i][1]){
                maxPower *= -1;
            }
            if (coords[i + 1][0] < coords[i][0]){
                angle *= -1;
            }

            movement.MoveWithAngle(angle, 0, maxPower, distancia);
        }

    }
}
