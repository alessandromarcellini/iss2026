%====================================================================================
% firefly description   
%====================================================================================
dispatch( cellstate, cellstate(X,Y,COLOR) ).
dispatch( shareFrequency, shareFrequency(Frequency) ).
dispatch( measureInsufficient, measureInsufficient(s) ).
dispatch( measureSufficient, measureSufficient(s) ).
event( sync, sync(CurrBestMillis) ).
event( unsync, unsync(unsync) ).
%====================================================================================
context(ctxfirefly, "localhost",  "TCP", "8040").
context(ctxgrid, "127.0.0.1",  "TCP", "8050").
 qactor( griddisplay, ctxgrid, "external").
  qactor( creator, ctxfirefly, "it.unibo.creator.Creator").
 static(creator).
  qactor( sonar, ctxfirefly, "it.unibo.sonar.Sonar").
 static(sonar).
  qactor( fireflies_orchestrator, ctxfirefly, "it.unibo.fireflies_orchestrator.Fireflies_orchestrator").
 static(fireflies_orchestrator).
  qactor( firefly, ctxfirefly, "it.unibo.firefly.Firefly").
dynamic(firefly). %%Oct2023 
