'use client'

import { Formik, Form } from 'formik'
import Image from 'next/image'

interface FormikInitialValues {
    email: string
    password: string
}

const initialValues: FormikInitialValues = {
    email: '',
    password: '',
}

const PrimaryInput = () => {
    return <input />
}

export default function LoginPage() {
    const onSubmit = (values: FormikInitialValues) => {}

    return (
        <main className={'w-full h-full pt-24'}>
            <section className={'w-full flex flex-col items-center'}>
                <Image
                    width={198}
                    height={70}
                    src={'/facebook.png'}
                    alt={'Facebook logo'}
                    // fill
                />
                <Formik<FormikInitialValues>
                    initialValues={initialValues}
                    onSubmit={onSubmit}
                >
                    <Form
                        className={
                            'w-full flex flex-col bg-white drop-shadow-sm pt-3 pb-6 max-w-sm px-3'
                        }
                    >
                        <PrimaryInput />
                        <PrimaryInput />
                    </Form>
                </Formik>
            </section>
        </main>
    )
}
