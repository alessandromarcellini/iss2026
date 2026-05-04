%====================================================================================
% fireflysynch description   
%====================================================================================
event( globalStart, globalStart(start) ).
dispatch( cellstate, cellstate(X,Y,COLOR) ).
dispatch( synch_up, synch_up(synch) ).
event( outerFlash, outerFlash(T) ).
event( measureInsufficient, measureInsufficient(s) ).
event( measureSufficient, measureSufficient(s) ).
%====================================================================================
context(ctxfirefly, "localhost",  "TCP", "8040").
context(ctxgrid, "127.0.0.1",  "TCP", "8050").
 qactor( griddisplay, ctxgrid, "external").
  qactor( creator, ctxfirefly, "it.unibo.creator.Creator").
 static(creator).
  qactor( sonar, ctxfirefly, "it.unibo.sonar.Sonar").
 static(sonar).
  qactor( firefly, ctxfirefly, "it.unibo.firefly.Firefly").
dynamic(firefly). %%Oct2023 
