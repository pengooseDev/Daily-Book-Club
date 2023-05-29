print 함수를 생각해보자. 모든 type을 매개변수로 받고 그걸 print한다.
그렇다면 이것의 callSignature는 어떻게 작성할 것인가?

```ts
type Print ={
	(arr:number[]):void
	(arr:boolean[]):void
	(arr:string[]):void

	(arr:(number|boolean)[]):void
	(arr:(number|string)[]):void
	(arr:(string|boolean)[]):void

	.
	.
	.
}
```

모든 경우의 수를 적으려면 끝이 없다.
이런 경우 Generic을 사용한다.

이름으로는 T, V 등등 다양하게씀. 이름 상관없음.

```ts
//모든 type의 인자가 든 배열을 받아서, 아무것도 return하지 않음.
type Print = {
  <T>(arr: T[]): void;
};
```

이를 Generic 타입이라 부름.

```ts
//모든 type의 인자가 든 배열을 받아서, 모든 Type return 가능.
type Print = {
  <T>(arr: T[]): T;
};
```

## Generic 추가 가능.

```ts
//모든 type의 인자가 든 배열을 받아서, 모든 Type return 가능.
type Print = {
  <T, V>(a: T[], b: V): T;
};
```

# `Any`랑은 다름.

우리가 넣는 값으로 CallSignature을 생성함.
