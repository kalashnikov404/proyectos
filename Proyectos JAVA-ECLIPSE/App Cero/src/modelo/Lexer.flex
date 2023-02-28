package modelo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+

F=[ ("(^[0-9]{1,5}\\.[0-9]{1,2}$)")]+



espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
/* Salto de linea */
( "\n" ) {return Linea;}

{espacio} {/*Ignore*/}

INICIO {lexeme=yytext(); return INICIO;}
FIN {lexeme=yytext(); return FIN;}
ENTERO {lexeme=yytext(); return ENTERO;}
DECIMAL {lexeme=yytext(); return DECIMAL;}
LEER {lexeme=yytext(); return LEER;}
ESCRIBIR {lexeme=yytext(); return ESCRIBIR;}
SUM {lexeme=yytext(); return SUM;}
MUL {lexeme=yytext(); return MUL;}
DIV {lexeme=yytext(); return DIV;}
RES {lexeme=yytext(); return RES;}


"=" {lexeme=yytext(); return Igual;}
"{" {lexeme=yytext(); return Corchete_Abierto;}
"}" {lexeme=yytext(); return Corchete_Cerrado;}
"(" {lexeme=yytext(); return Parentesis_Abierto;}
")" {lexeme=yytext(); return Parentesis_Cerrado;}
";" {lexeme=yytext(); return Punto_Coma;}
"\\," {lexeme=yytext(); return Coma;}
"." {lexeme=yytext(); return Punto;}



/* Identificador */
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}

/* Numero */
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}

{F} {lexeme=yytext(); return Real;}



 . {return ERROR;}
 
 
 