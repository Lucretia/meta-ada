with Ada.Text_IO; use Ada.Text_IO;
with libHello;

procedure Hello is
   C : Integer := libHello.Add(5, 10);
begin
   Put_Line ("Hello, Ada");
   Put_Line ("Add(5, 10) = " & Integer'Image(C));
end Hello;
