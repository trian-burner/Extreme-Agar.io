import greenfoot.*;

public abstract class ScrollActor extends Actor
{
        private int camX, camY;
        private int globalX, globalY;
        private boolean isCameraFollower;
        private ScrollWorld world;
            
        public ScrollActor()
         {
             camX = 0;
             camY = 0;
             globalX = 0;
             globalY = 0;
             isCameraFollower = false;
             world = null;
         }
        
        public int getGlobalX()
        {
            if (world == null){
                throw new IllegalStateException("Actor not in world. Either is hasn't"+
                " been inserted, or it has been deleted.");
            }
            return globalX;
        }
        
        public int getGlobalY()
        {
            if (world == null){
                throw new IllegalStateException("Actor not in world. Either is hasn't"+
                " been inserted, or it has been deleted.");
            }
            
            return globalY;
        }
        
        /**
         * Returns your x coördinate seen from the camera.
         */
        public int getXFromCamera()
        {
            if (world == null){
                throw new IllegalStateException("Actor not in world. Either is hasn't"+
                " been inserted, or it has been deleted.");
            }
            return camX;
        }
        
        /**
         * Returns your y coördinate seen from the camera.
         */
        public int getYFromCamera()
        {
            if (world == null){
                throw new IllegalStateException("Actor not in world. Either is hasn't"+
                " been inserted, or it has been deleted.");
            }
            return camY;
        }
        
        /**
         * Sets your location seen from the world
         * (regular location).
         * That means that a negative location is off
         * screen, and bigger than the world's size is
         * also off screen.
         */
        public void setLocation(int x, int y)
        {
            if (world == null) return;
            super.setLocation(x,y);
            int halfWorldWidth = world.getWidth() /2;
            int halfWorldHeight = world.getHeight() /2;
            camX = x -halfWorldWidth;
            camY = y -halfWorldHeight;
            globalX = x +(world.getCameraX() -halfWorldWidth);
            globalY = y +(world.getCameraY() -halfWorldHeight);
        }
        
        /**
         * Sets your location seen from the camera.
         */
        public void setLocationFromCamera(int x, int y)
        {
            setLocation(x +world.getCameraX(), y +world.getCameraY());
        }
        
        /**
         * Sets your location in the big space (the
         * space where the camera is moving over).
         */
        public void setGlobalLocation(int x, int y)
        {
            int subX = world.getCameraX() -world.getWidth() /2;
            int subY = world.getCameraY() -world.getHeight() /2;
            setLocation(x -subX, y -subY);
        }
        
        /** OTHER METHODS: */
        
        /**
         * Returns the ScrollWorld you're in.
         * If you're not in a world, this will return null.
         */
        public ScrollWorld getWorld()
        {
            return world;
        }
        
        /**
         * Moves the scroll actor forward a specified amount.
         * To go backwards, enter a negative number.<p>
         * This will affect all the locations of the
         * scroll actor.
         * @param distance The number of cells the scroll
         * actor will move forward.
         */
        public void move(int distance)
        {
            if (distance == 0) return;
            double radians = Math.toRadians(getRotation());
            double sin = Math.sin(radians);
            double cos = Math.cos(radians);
            int dx = (int)Math.round(cos *distance);
            int dy = (int)Math.round(sin *distance);
            setLocation(getX() +dx, getY() +dy);
        }
        
        /**
         * Turns towards a location in the big space.
         * @param x The x coördinate of the location.
         * @param y The y coördinate of the location.
         */
        public void turnTowardsGlobalLocation(int x, int y)
        {
            if (x == globalX && y == globalY) return;
            double a = Math.atan2(y -globalY, x -globalX);
            int newRotation = (int)Math.round(Math.toDegrees(a));
            setRotation(newRotation);
        }
        
        /**
         * Turns towards a location seen from the camera.
         * @param x The x coördinate of the location.
         * @param y The y coördinate of the location.
         */
        public void turnTowardsCameraLocation(int x, int y)
        {
            if (x == camX && y == camY) return;
            double a = Math.atan2(y -camY, x -camX);
            int newRotation = (int)Math.round(Math.toDegrees(a));
            setRotation(newRotation);
        }
        
        /**
         * Returns you're a camera follower or not.
         * If you're not in a world, this will throw an
         * exception.
         */
        public boolean isCameraFollower()
        {
            if (world == null)
                throw new IllegalStateException("Actor not in world. Either is hasn't"+
                " been inserted, or it has been deleted.");
            return isCameraFollower;
        }
        
        /**
         * Used by the system: don't touch!
         */
        void setIsCameraFollower(boolean value)
        {
            this.isCameraFollower = value;
            this.world = (ScrollWorld) super.getWorld();
            if (value) {
                setLocation(getX(), getY());
            }
        }
    }
