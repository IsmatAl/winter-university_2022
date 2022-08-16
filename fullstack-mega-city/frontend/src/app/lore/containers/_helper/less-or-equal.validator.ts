import { FormGroup } from '@angular/forms';

export function LessOrEqual(controlName: string, capacity: string) {
    return (formGroup: FormGroup) => {
        const control = formGroup.controls[controlName];
        const capacityControl = formGroup.controls[capacity];

        if (+control.value > +capacityControl.value) {
            control.setErrors({ lessOrEqual: true });
        }

    }
}
