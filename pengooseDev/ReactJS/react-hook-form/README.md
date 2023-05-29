### `register`

input과 state를 연결해주는 역할.
register은 4가지를 담고있는 객체이다.

1. name
2. onBlur
3. onChange
4. ref

```tsx
const Form = () => {
  const { register } = useForm();
  const { name, ref, onChange, onBlur } = register('formName');
  return (
    <form>
      <input name={name} ref={ref} onChange={onChange} onBlur={onBlur} />
    </form>
  );
};
```

위처럼 하나하나 구조분해할당 및 선언이 귀찮으니 아래와 같이 spread연산자를 이용한 shortcut을 사용한다.
