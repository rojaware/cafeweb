package com.rojaware.members;

class RunnableDemo
{
   public static void main (String [] args)
   {
      Rectangle r = new Rectangle (5, 6);
      r.draw ();
      // Draw various rectangles with randomly-chosen widths and heights
      new Rectangle ();
   }
}
abstract class Shape
{
   abstract void draw ();
}
class Rectangle extends Shape implements Runnable
{
   private int w, h;
   Rectangle ()
   {
      // Create a new Thread object that binds to this runnable and start
      // a thread that will call this runnable's run() method
      new Thread (this).start ();
   }
   Rectangle (int w, int h)
   {
      if (w < 2)
          throw new IllegalArgumentException ("w value " + w + " < 2");
      if (h < 2)
          throw new IllegalArgumentException ("h value " + h + " < 2");
      this.w = w;
      this.h = h;
   }
   void draw ()
   {
      for (int c = 0; c < w; c++)
           System.out.print ('*');
      System.out.print ('\n');
      for (int r = 0; r < h - 2; r++)
      {
           System.out.print ('*');
           for (int c = 0; c < w - 2; c++)
                System.out.print (' ');
           System.out.print ('*');
           System.out.print ('\n');
      }
      for (int c = 0; c < w; c++)
           System.out.print ('*');
      System.out.print ('\n');
   }
   public void run ()
   {
      for (int i = 0; i < 20; i++)
      {
           w = rnd (30);
           if (w < 2)
               w += 2;
           h = rnd (10);
           if (h < 2)
               h += 2;
           draw ();
      }
   }
   int rnd (int limit)
   {
      // Return a random number x in the range 0 <= x < limit
      return (int) (Math.random () * limit);
   }
}