'''
Created on 23 feb. 2022

@author: Rodrigo Blancas Morales
'''
import string

s1=input("Ingresa la cadena A: ")
s2=input("Ingresa la cadena B: ")


cadenaCorta = min(s1, s2, key=len)
cadenaLarga = max(s1, s2, key=len)
print("Cadena Corta:", cadenaCorta ,"",  "Cadena Larga:", cadenaLarga)

if len(cadenaCorta)==len(cadenaLarga): print("Ambas cadenas son de la misma longitud: Incorrecto")
    
else:print(cadenaCorta,"+", cadenaLarga, "+",cadenaCorta)









