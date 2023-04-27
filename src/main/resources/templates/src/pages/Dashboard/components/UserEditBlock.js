import {useForm} from "react-hook-form";

export function UserEditBlock({user}) {
    const {register, handleSubmit} = useForm();
    const submitForm = (data) => {
        console.log(data)
    }
    return (
        <form onSubmit={handleSubmit(submitForm)}>
            <div className="d-flex mb-2 mt-3 flex-column align-item-center justify-content-center">
                <label htmlFor="name"  className={"text-center my-2"} > Nom </label>
                <input  className="text-input"
                        type="text"
                        placeholder="Nom"
                        id={"name"}
                        defaultValue={user.name}
                        required={true}
                        {...register("name", {required: true})}
                />
            </div>
            <div className="d-flex mb-2 mt-3 flex-column align-item-center justify-content-center">
                <label htmlFor="surname"  className={"text-center my-2"} > Prénom</label>
                <input className="text-input"
                       type="text"
                       placeholder="Prénom"
                       id={"surname"}
                       defaultValue={user.surname}
                       required={true}
                       {...register("surname", {required: true})}
                />
            </div>
            <div className="d-flex mb-2 mt-3 flex-column align-item-center justify-content-center">
                <label htmlFor="mail"  className={"text-center my-2"} > Email</label>
                <input className="text-input"
                       type="mail"
                       placeholder="mail"
                       id={"mail"}
                       defaultValue={user.mail}
                       required={true}
                       {...register("mail", {required: true})}
                />
            </div>
            <div className="d-flex mb-2 mt-3 flex-column align-item-center justify-content-center">
                <label htmlFor="cv" className={"text-center my-2"} >
                    Cv
                </label>
                <input
                    id={"cv"}  type="file" placeholder="cv" className="file-input"/>
            </div>
            <div className="submit-btn text-center pt-2">
                <button className="btn btn-primary btn-sm ">Modifier les informations</button>
            </div>
        </form>
    )
}