package conway.domain;

import io.javalin.websocket.WsMessageContext;

public class WsOutDev implements IOutDev {

    private WsMessageContext ctx;

    public void setCtx(WsMessageContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public void display(String msg) {
        if (ctx != null) ctx.send(msg);
    }

    @Override
    public void displayCell(IGrid grid, int x, int y) {
        if (ctx != null) {
            int color = grid.getCellStatus(x, y) ? 0 : 1;
            ctx.send("cell(" + x + "," + y + "," + color + ")");
        }
    }

    @Override
    public void displayGrid(IGrid grid) {
        if (ctx != null) {
            for (int x = 0; x < grid.getNumRows(); x++) {
                for (int y = 0; y < grid.getNumCols(); y++) {
                	this.displayCell(grid, x, y);
                }
            }
        }
    }

    @Override
    public void close() {}
}