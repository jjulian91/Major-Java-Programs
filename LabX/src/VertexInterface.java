   i   m   p   o   r   t       j   a   v   a   .   u   t   i   l   .   I   t   e   r   a   t   o   r   ;   
   /   *   *   
       *       A   n       i   n   t   e   r   f   a   c   e       f   o   r       a       v   e   r   t   e   x       i   n       a       g   r   a   p   h   .   
       *       
       *       @   a   u   t   h   o   r       F   r   a   n   k       M   .       C   a   r   r   a   n   o   
       *       @   v   e   r   s   i   o   n       2   .   0   
       *   /   
   p   u   b   l   i   c       i   n   t   e   r   f   a   c   e       V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >   
   {   
           /   *   *       T   a   s   k   :       G   e   t   s       t   h   e       v   e   r   t   e   x  ��   s       l   a   b   e   l   .   
               *           @   r   e   t   u   r   n       t   h   e       o   b   j   e   c   t       t   h   a   t       l   a   b   e   l   s       t   h   e       v   e   r   t   e   x       *   /   
           p   u   b   l   i   c       T       g   e   t   L   a   b   e   l   (   )   ;   
           
           /   *   *       T   a   s   k   :       M   a   r   k   s       t   h   e       v   e   r   t   e   x       a   s       v   i   s   i   t   e   d   .       *   /   
           p   u   b   l   i   c       v   o   i   d       v   i   s   i   t   (   )   ;   
           
           /   *   *       T   a   s   k   :       R   e   m   o   v   e   s       t   h   e       v   e   r   t   e   x  ��   s       v   i   s   i   t   e   d       m   a   r   k   .       *   /   
           p   u   b   l   i   c       v   o   i   d       u   n   v   i   s   i   t   (   )   ;   
           
           /   *   *       T   a   s   k   :       S   e   e   s       w   h   e   t   h   e   r       t   h   e       v   e   r   t   e   x       i   s       m   a   r   k   e   d       a   s       v   i   s   i   t   e   d   .   
               *           @   r   e   t   u   r   n       t   r   u   e       i   f       t   h   e       v   e   r   t   e   x       i   s       v   i   s   i   t   e   d       *   /   
           p   u   b   l   i   c       b   o   o   l   e   a   n       i   s   V   i   s   i   t   e   d   (   )   ;   
           
           /   *   *       T   a   s   k   :       C   o   n   n   e   c   t   s       t   h   i   s       v   e   r   t   e   x       a   n   d       a       g   i   v   e   n       v   e   r   t   e   x       w   i   t   h       a       w   e   i   g   h   t   e   d       e   d   g   e   .   
               *                                   T   h   e       t   w   o       v   e   r   t   i   c   e   s       c   a   n   n   o   t       b   e       t   h   e       s   a   m   e   ,       a   n   d       m   u   s   t       n   o   t       a   l   r   e   a   d   y   
               *                                   h   a   v   e       t   h   i   s       e   d   g   e       b   e   t   w   e   e   n       t   h   e   m   .       I   n       a       d   i   r   e   c   t   e   d       g   r   a   p   h   ,       t   h   e       e   d   g   e       
               *                                   p   o   i   n   t   s       t   o   w   a   r   d       t   h   e       g   i   v   e   n       v   e   r   t   e   x   .   
               *           @   p   a   r   a   m       e   n   d   V   e   r   t   e   x               a       v   e   r   t   e   x       i   n       t   h   e       g   r   a   p   h       t   h   a   t       e   n   d   s       t   h   e       e   d   g   e   
               *           @   p   a   r   a   m       e   d   g   e   W   e   i   g   h   t           a       r   e   a   l   -   v   a   l   u   e   d       e   d   g   e       w   e   i   g   h   t   ,       i   f       a   n   y   
               *           @   r   e   t   u   r   n       t   r   u   e       i   f       t   h   e       e   d   g   e       i   s       a   d   d   e   d   ,       o   r       f   a   l   s   e       i   f       n   o   t       *   /   
           p   u   b   l   i   c       b   o   o   l   e   a   n       c   o   n   n   e   c   t   (   V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >       e   n   d   V   e   r   t   e   x   ,       
                                                                                                       d   o   u   b   l   e       e   d   g   e   W   e   i   g   h   t   )   ;   
                                                                                                       
           /   *   *       T   a   s   k   :       C   o   n   n   e   c   t   s       t   h   i   s       v   e   r   t   e   x       a   n   d       a       g   i   v   e   n       v   e   r   t   e   x       w   i   t   h       a   n       u   n   w   e   i   g   h   t   e   d       
               *                                   e   d   g   e   .       T   h   e       t   w   o       v   e   r   t   i   c   e   s       c   a   n   n   o   t       b   e       t   h   e       s   a   m   e   ,       a   n   d       m   u   s   t       n   o   t       
               *                                   a   l   r   e   a   d   y       h   a   v   e       t   h   i   s       e   d   g   e       b   e   t   w   e   e   n       t   h   e   m   .       I   n       a       d   i   r   e   c   t   e   d       g   r   a   p   h   ,       
               *                                   t   h   e       e   d   g   e       p   o   i   n   t   s       t   o   w   a   r   d       t   h   e       g   i   v   e   n       v   e   r   t   e   x   .   
               *           @   p   a   r   a   m       e   n   d   V   e   r   t   e   x               a       v   e   r   t   e   x       i   n       t   h   e       g   r   a   p   h       t   h   a   t       e   n   d   s       t   h   e       e   d   g   e   
               *           @   r   e   t   u   r   n       t   r   u   e       i   f       t   h   e       e   d   g   e       i   s       a   d   d   e   d   ,       o   r       f   a   l   s   e       i   f       n   o   t       *   /   
           p   u   b   l   i   c       b   o   o   l   e   a   n       c   o   n   n   e   c   t   (   V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >       e   n   d   V   e   r   t   e   x   )   ;   
           
           /   *   *       T   a   s   k   :       C   r   e   a   t   e   s       a   n       i   t   e   r   a   t   o   r       o   f       t   h   i   s       v   e   r   t   e   x   '   s       n   e   i   g   h   b   o   r   s       b   y       f   o   l   l   o   w   i   n   g       
               *                                   a   l   l       e   d   g   e   s       t   h   a   t       b   e   g   i   n       a   t       t   h   i   s       v   e   r   t   e   x   .   
               *           @   r   e   t   u   r   n       a   n       i   t   e   r   a   t   o   r       o   f       t   h   e       n   e   i   g   h   b   o   r   i   n   g       v   e   r   t   i   c   e   s       o   f       t   h   i   s       v   e   r   t   e   x       *   /   
           p   u   b   l   i   c       I   t   e   r   a   t   o   r   <   V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >   >       g   e   t   N   e   i   g   h   b   o   r   I   t   e   r   a   t   o   r   (   )   ;   
   
           /   *   *       T   a   s   k   :       C   r   e   a   t   e   s       a   n       i   t   e   r   a   t   o   r       o   f       t   h   e       w   e   i   g   h   t   s       o   f       t   h   e       e   d   g   e   s       t   o       t   h   i   s       
               *                                   v   e   r   t   e   x   '   s       n   e   i   g   h   b   o   r   s   .   
               *           @   r   e   t   u   r   n       a   n       i   t   e   r   a   t   o   r       o   f       e   d   g   e       w   e   i   g   h   t   s       f   o   r       e   d   g   e   s       t   o       n   e   i   g   h   b   o   r   s       o   f       t   h   i   s       
               *                                           v   e   r   t   e   x       *   /   
           p   u   b   l   i   c       I   t   e   r   a   t   o   r   <   D   o   u   b   l   e   >       g   e   t   W   e   i   g   h   t   I   t   e   r   a   t   o   r   (   )   ;   
           
           /   *   *       T   a   s   k   :       S   e   e   s       w   h   e   t   h   e   r       t   h   i   s       v   e   r   t   e   x       h   a   s       a   t       l   e   a   s   t       o   n   e       n   e   i   g   h   b   o   r   .   
               *           @   r   e   t   u   r   n       t   r   u   e       i   f       t   h   e       v   e   r   t   e   x       h   a   s       a       n   e   i   g   h   b   o   r       *   /   
           p   u   b   l   i   c       b   o   o   l   e   a   n       h   a   s   N   e   i   g   h   b   o   r   (   )   ;   
           
           /   *   *       T   a   s   k   :       G   e   t   s       a   n       u   n   v   i   s   i   t   e   d       n   e   i   g   h   b   o   r   ,       i   f       a   n   y   ,       o   f       t   h   i   s       v   e   r   t   e   x   .   
               *           @   r   e   t   u   r   n       e   i   t   h   e   r       a       v   e   r   t   e   x       t   h   a   t       i   s       a   n       u   n   v   i   s   i   t   e   d       n   e   i   g   h   b   o   r       o   r       n   u   l   l   
               *                                           i   f       n   o       s   u   c   h       n   e   i   g   h   b   o   r       e   x   i   s   t   s       *   /   
           p   u   b   l   i   c       V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >       g   e   t   U   n   v   i   s   i   t   e   d   N   e   i   g   h   b   o   r   (   )   ;   
           
           /   *   *       T   a   s   k   :       R   e   c   o   r   d   s       t   h   e       p   r   e   v   i   o   u   s       v   e   r   t   e   x       o   n       a       p   a   t   h       t   o       t   h   i   s       v   e   r   t   e   x   .   
               *           @   p   a   r   a   m       p   r   e   d   e   c   e   s   s   o   r           t   h   e       v   e   r   t   e   x       p   r   e   v   i   o   u   s       t   o       t   h   i   s       o   n   e       a   l   o   n   g       a       p   a   t   h       *   /   
           p   u   b   l   i   c       v   o   i   d       s   e   t   P   r   e   d   e   c   e   s   s   o   r   (   V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >       p   r   e   d   e   c   e   s   s   o   r   )   ;   
           
           /   *   *       T   a   s   k   :       G   e   t   s       t   h   e       r   e   c   o   r   d   e   d       p   r   e   d   e   c   e   s   s   o   r       o   f       t   h   i   s       v   e   r   t   e   x   .   
               *           @   r   e   t   u   r   n       e   i   t   h   e   r       t   h   i   s       v   e   r   t   e   x  ��   s       p   r   e   d   e   c   e   s   s   o   r       o   r       n   u   l   l       i   f       n   o       p   r   e   d   e   c   e   s   s   o   r       
               *                                           w   a   s       r   e   c   o   r   d   e   d       *   /   
           p   u   b   l   i   c       V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   <   T   >       g   e   t   P   r   e   d   e   c   e   s   s   o   r   (   )   ;   
           
           /   *   *       T   a   s   k   :       S   e   e   s       w   h   e   t   h   e   r       a       p   r   e   d   e   c   e   s   s   o   r       w   a   s       r   e   c   o   r   d   e   d   .   
               *           @   r   e   t   u   r   n       t   r   u   e       i   f       a       p   r   e   d   e   c   e   s   s   o   r       w   a   s       r   e   c   o   r   d   e   d       f   o   r       t   h   i   s       v   e   r   t   e   x       *   /   
           p   u   b   l   i   c       b   o   o   l   e   a   n       h   a   s   P   r   e   d   e   c   e   s   s   o   r   (   )   ;   
           
           /   *   *       T   a   s   k   :       R   e   c   o   r   d   s       t   h   e       c   o   s   t       o   f       a       p   a   t   h       t   o       t   h   i   s       v   e   r   t   e   x   .   
               *           @   p   a   r   a   m       n   e   w   C   o   s   t           t   h   e       c   o   s   t       o   f       t   h   e       p   a   t   h       *   /   
           p   u   b   l   i   c       v   o   i   d       s   e   t   C   o   s   t   (   d   o   u   b   l   e       n   e   w   C   o   s   t   )   ;   
           
           /   *   *       T   a   s   k   :       G   e   t   s       t   h   e       r   e   c   o   r   d   e   d       c   o   s   t       o   f       t   h   e       p   a   t   h       t   o       t   h   i   s       v   e   r   t   e   x   .   
               *           @   r   e   t   u   r   n       t   h   e       c   o   s   t       o   f       t   h   e       p   a   t   h       *   /   
           p   u   b   l   i   c       d   o   u   b   l   e       g   e   t   C   o   s   t   (   )   ;   
   }       /   /       e   n   d       V   e   r   t   e   x   I   n   t   e   r   f   a   c   e   
