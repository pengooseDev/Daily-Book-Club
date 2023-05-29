/* React hook form 없이 구현 */
export default function Forms() {
  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [formErrors, setFormErrors] = useState();
  const [emailErrors, setEmailErrors] = useState();

  const onUsernameChange = (event: React.SynctheticEvent<HTMLInputElement>) => {
    const {
      currentTarget: { value },
    } = event;
    setEmailErrors('');
    setUsername(value);
  };

  const onEmailChange = (event: React.SynctheticEvent<HTMLInputElement>) => {
    const {
      currentTarget: { value },
    } = event;
    setEmailErrors('');
    setEmail(value);
  };

  const onPasswordChange = (event: React.SynctheticEvent<HTMLInputElement>) => {
    const {
      currentTarget: { value },
    } = event;
    setEmailErrors('');
    setPassword(value);
  };

  const onSubmit = (event: React.SynctheticEvent<HTMLInputElement>) => {
    console.log(username, email, password);

    event.preventDefault();
    if (username === '' || email === '' || password === '') {
      setFormErrors('All fields are required');
    }

    if (!email.includes('@')) {
      setEmailErrors('email is required');
    }
  };

  return (
    <form onSubmit={onSubmit}>
      <input
        required
        value={username}
        onChange={onUsernameChange}
        type="text"
        placeholder="Username"
      />
      <input
        required
        value={email}
        onChange={onEmailChange}
        type="email"
        placeholder="Email"
      />
      <input
        required
        value={password}
        onChange={onPasswordChange}
        type="password"
        placeholder="Password"
      />
      <input type="submit" value="Create Account" />
    </form>
  );
}
