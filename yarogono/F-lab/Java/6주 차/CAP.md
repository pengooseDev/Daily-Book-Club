# π μ°Έκ³ μλ£

---

- IBM - CAP μ λ¦¬ β [**λ§ν¬**](https://www.ibm.com/kr-ko/cloud/learn/cap-theorem)
- Wikipedia - CAP theorem β **[λ§ν¬](https://en.wikipedia.org/wiki/CAP_theorem)**
- μν€λ°±κ³Ό - CAP μ λ¦¬ β [**λ§ν¬**](https://ko.wikipedia.org/wiki/CAP_%EC%A0%95%EB%A6%AC)
- μ νλΈ μ±λ <IBM Technology> - What is CAP Theorem? β [**λ§ν¬**](https://www.youtube.com/watch?v=eWMgsk7mpFc)

# βκ³΅λΆ λ΄μ© μ λ¦¬

---

![CapImage.07cc2b7.dd8b935c30da4454e015c7f8d2451c9c.png](https://s3.us-west-2.amazonaws.com/secure.notion-static.com/1dab9a0b-026b-4637-8d90-488e46299e46/CapImage.07cc2b7.dd8b935c30da4454e015c7f8d2451c9c.png?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Content-Sha256=UNSIGNED-PAYLOAD&X-Amz-Credential=AKIAT73L2G45EIPT3X45%2F20230218%2Fus-west-2%2Fs3%2Faws4_request&X-Amz-Date=20230218T130830Z&X-Amz-Expires=86400&X-Amz-Signature=8858c9231bc04c90614a83c2a775e8f5cabc718c2e2e417f84af2fcf59a6d9c0&X-Amz-SignedHeaders=host&response-content-disposition=filename%3D%22CapImage.07cc2b7.dd8b935c30da4454e015c7f8d2451c9c.png%22&x-id=GetObject)

## βCAPλ?

λ€νΈμν¬λ‘ μ°κ²°λ λΆμ°λ λ°μ΄ν°λ² μ΄μ€ μμ€νμ μΌκ΄μ±(Consistency), κ°μ©μ±(Availability), λΆν  λ΄κ΅¬μ±(Partition Tolerance)μ 3κ°μ§ νΉμ± μ€ 2κ°μ§ νΉμ±λ§μ μΆ©μ‘±ν  μ μκ³  3κ°μ§λ₯Ό λͺ¨λ μΆ©μ‘±ν  μ μλ€λ μ΄λ‘ 

## μΌκ΄μ±(Consistency)

- λͺ¨λ  λΈλκ° κ°μ μκ°μ κ°μ λ°μ΄ν°λ₯Ό λ³Ό μ μλ€.
    - μ΄λ¬ν μν©μ΄ λ°μνλ €λ©΄, λ°μ΄ν°κ° νλμ λΈλμ κΈ°λ‘λ  λλ§λ€ λ°μ΄ν°λ μ°κΈ°κ° βμ±κ³΅βμΌλ‘ κ°μ£ΌλκΈ° μ μ μμ€νμ λ€λ₯Έ λͺ¨λ  λΈλλ‘ μ¦μ μ λ¬λκ±°λ λ³΅μ λμ΄μΌ νλ€.

## κ°μ©μ±(Availability)

- λͺ¨λ  μμ²­μ΄ μ±κ³΅ λλ μ€ν¨ κ²°κ³Όλ₯Ό λ°νν  μ μλ€.
- νλ μ΄μμ λΈλκ° μλ μ€μ§λ κ²½μ°μλ λ°μ΄ν°λ₯Ό μμ²­νλ ν΄λΌμ΄μΈνΈκ° μλ΅μ λ°μμ μλ―Έ
    - λΆμ° μμ€νμ λͺ¨λ  μμ μ€μΈ λΈλλ μμΈ μμ΄ λͺ¨λ  μμ²­μ λν΄ μ ν¨ν μλ΅μ λ¦¬ν΄νλ€.

## λΆν λ΄μ±(Partition tolerance)

- λ©μμ§ μ λ¬μ΄ μ€ν¨νκ±°λ μμ€ν μΌλΆκ° λ§κ°μ Έλ μμ€νμ΄ κ³μ λμν  μ μλ€.
