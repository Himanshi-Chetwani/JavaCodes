
class Ship {
    private int length;
    private int start_x;
    private int start_y;
    private int end_x;
    private int end_y;
    int shipHealth;

    Ship(int startX, int startY, int endX,
         int endY) {
        length =
                1 + (int) Math.sqrt(((endX - startX) * (endX - startX)) + ((endY - startY) * (endY - startY)));
        this.start_x = startX;
        this.start_y = startY;
        this.end_x = endX;
        this.end_y = endY;
        this.shipHealth = length;
    }


}