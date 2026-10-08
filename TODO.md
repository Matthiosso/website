# TODO

## Privacy

- [ ] Stop sending contact form personal data to Umami.
  `frontend/src/components/layout/Contact.vue` attaches the visitor's email and subject
  to the `submit_contact_form` event (`data-umami-event-email`, `data-umami-event-subject`),
  so they end up stored in the analytics database. Remove both attributes, then delete
  the event data already collected in Umami.
