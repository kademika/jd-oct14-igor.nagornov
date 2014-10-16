package Tanks.TanksOOP;

public class Tank {
	
	// 1 - top, 2 - bottom, 3 - left, 4 - right
		private int direction;
		private int x;
		private int y;		
		private int speed=10;
		private ActionField actionfield;
		private BattleField battlefield;
		
		public Tank(ActionField actionfield, BattleField battlefield, int x, int y, int direction){
			this.actionfield = actionfield;
			this.battlefield = battlefield;
			this.x = x;
			this.y = y;		
			this.direction = direction;
		}
		
		public Tank(ActionField actionfield, BattleField battlefield){
			this(actionfield, battlefield, 192, 128, 2);
		}

		public int getDirection() {
			return direction;
		}

		public int getX() {
			return x;
		}		

		public int getY() {
			return y;
		}

		public int getSpeed() {
			return speed;
		}
		
		public ActionField getActionfield() {
			return actionfield;
		}

		public BattleField getBattlefield() {
			return battlefield;
		}
		
		public void updateX(int x){
			this.x += x;
		}
		
		public void updateY(int y){
			this.y += y;
		}		
		
		public void turn (int direction) throws Exception{
			if (this.direction != direction) {
				this.direction = direction;
				actionfield.processTurn(this);
			}
		}
		
		public void move() throws Exception{
			actionfield.processMove(this);
		}
		
		public void moveRandom() throws Exception{
			actionfield.processMoveRandom(this);
		}
		
		public void fire() throws Exception{
			Bullet bullet = new Bullet(x + 25, y + 25, direction);
			actionfield.processFire(bullet);
		}		
		
		public void moveToQuadrant(int v, int h) throws Exception{
			actionfield.processMoveToQuadrant(this, v, h);
		}
		

}
