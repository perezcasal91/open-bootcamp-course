# Encryption

It is the process of encoding information from its original representation (plain text) to encrypted text, 
so that it can only be decrypted using a key.

## Encryption History:

1. Store passwords in plain text.
2. Store encrypted passwords with a Hash Function.
3. Store encrypted passwords with a Hash Function + Salt.
4. Store encrypted passwords with an Adaptive Function + Work Factor.

Gains Security by making passwords validation computationally expensive.

## Spring Security Algorithms

* BCrypt
* PBKDF2
* SCrypt
* Argon2