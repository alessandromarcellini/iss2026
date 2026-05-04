%====================================================================================
% firefly description   
%====================================================================================
dispatch( cellstate, cellstate(X,Y,COLOR) ).
dispatch( shareFrequency, shareFrequency(Frequency) ).
event( sync, sync(CurrBestMillis) ).
%====================================================================================
context(ctxfirefly, "localhost",  "TCP", "8040").
context(ctxgrid, "127.0.0.1",  "TCP", "8050").
 qactor( griddisplay, ctxgrid, "external").
  qactor( creator, ctxfirefly, "it.unibo.creator.Creator").
 static(creator).
  qactor( fireflies_orchestrator, ctxfirefly, "it.unibo.fireflies_orchestrator.Fireflies_orchestrator").
 static(fireflies_orchestrator).
  qactor( firefly, ctxfirefly, "it.unibo.firefly.Firefly").
dynamic(firefly). %%Oct2023 
