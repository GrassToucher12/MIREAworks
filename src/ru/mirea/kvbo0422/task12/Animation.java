package ru.mirea.kvbo0422.task12;

    import java.awt.*;
import java.awt.event.*;
    class Animation extends Frame
    {
        private Image[] img=new Image[4];
        private int count;
        Animation (String s)
        {
            super(s);
            MediaTracker tr=new MediaTracker(this);
            for (int k=0; k<4; k++)
            {
                img[k]=getToolkit().getImage("C:\\Users\\PC\\IdeaProjects\\MIREAworks\\src\\ru\\mirea\\kvbo0422\\task12\\image"+(k+1)+".gif");
                tr.addImage(img[k],0);
            }
            try
            {
                tr.waitForAll();
            }
            catch (InterruptedException e){}
            setSize(900, 900);
            setVisible(true);
        }
        public void paint(Graphics g)
        {
            g.drawImage(img[count%4], 0, 0, this);
        }
        public void update(Graphics g) {paint(g); }
        public void go()
        {
            while(count<100)
            {
                repaint();
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e){}
                count++;
            }
        }
        public static void main(String[] args)
        {
            Animation anim_window=new Animation("Simple Animation");
            anim_window.go();
            anim_window.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent ev)
                {
                    System.exit(0);
                }
            });
        }
    }
