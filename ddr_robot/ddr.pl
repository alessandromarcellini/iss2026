%====================================================================================
% ddr description   
%====================================================================================
event( currMeasure, currMeasure(CurrDistance) ).
event( rotate, rotate(Degrees) ).
event( move, move(Distance) ).
%====================================================================================
context(ctxddr, "localhost",  "TCP", "8040").
 qactor( sonar, ctxddr, "it.unibo.sonar.Sonar").
 static(sonar).
  qactor( robot, ctxddr, "it.unibo.robot.Robot").
 static(robot).
